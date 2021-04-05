package com.example.mysurgeon.surgeon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.surgeon.di.DaggerSurgeonComponent
import com.example.mysurgeon.surgeon.di.SurgeonModule
import com.example.mysurgeon.surgeon.repository.SurgeonRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SurgeonViewModel(val coreComponent: CoreComponent): BaseViewModel() {
    @Inject
    lateinit var repository: SurgeonRepository

    private val surgeonsModelList = mutableListOf<Surgeon>()
    private val stringIndexHashMap = HashMap<String, MutableList<Surgeon>>()

    private val _surgeons = MutableLiveData<List<Surgeon>>()
    val surgeons: LiveData<List<Surgeon>>
        get() = _surgeons

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    init {
        initComponentInjection()
    }

    fun search(query: String) {
        _surgeons.value = surgeonsModelList.filter { it.LastName!!.contains(query) }
    }

    fun loadSurgeons() {
        viewModelScope.launch {
           try {
               _status.value = Status.Loading(show = true)
               val surgeons = repository.getSurgeons()
               surgeonsModelList.clear()
               stringIndexHashMap.clear()
               surgeons.sortedBy { it.LastName }.forEach {
                   val model = Surgeon(SurgeonUniqueID = it.SurgeonUniqueID,
                       FirstName = it.FirstName,
                       LastName = it.LastName,
                       location = it.location,
                       surgeonImg = it.surgeonImg,
                       MobileNo = it.MobileNo,
                       FaxNo = it.FaxNo,
                       EMail = it.EMail,
                       MainNo = it.MainNo,
                       ContactPerson = it.ContactPerson,
                       Notes = it.Notes,
                       URL = it.URL,
                       State = it.State,
                       Hospital = it.Hospital,
                       Specialization = it.Specialization,
                       Zip = it.Zip,
                       WorkNo = it.WorkNo,
                       Street = it.Street,
                       City = it.City,
                       isHeader = false)
                   val firstLetterOfLastName = it.LastName?.first().toString()

                   var entitiesForThatString = stringIndexHashMap[firstLetterOfLastName]
                   if (entitiesForThatString == null) {
                       entitiesForThatString = ArrayList()
                       stringIndexHashMap[firstLetterOfLastName] = entitiesForThatString
                   }

                   if (entitiesForThatString.isEmpty()) {
                       val header = Surgeon(SurgeonUniqueID = it.SurgeonUniqueID,
                           FirstName = it.FirstName,
                           LastName = it.LastName,
                           location = it.location,
                           surgeonImg = it.surgeonImg,
                           MobileNo = it.MobileNo,
                           FaxNo = it.FaxNo,
                           EMail = it.EMail,
                           MainNo = it.MainNo,
                           Specialization = it.Specialization,
                           ContactPerson = it.ContactPerson,
                           Notes = it.Notes,
                           URL = it.URL,
                           Hospital = it.Hospital,
                           State = it.State,
                           Zip = it.Zip,
                           Street = it.Street,
                           City = it.City,
                           WorkNo = it.WorkNo,
                           isHeader = true)
                       val filteredSurgeonModelList = surgeonsModelList.filter { it.LastName?.first().toString() == firstLetterOfLastName }
                       if (filteredSurgeonModelList.isEmpty()) {
                           surgeonsModelList.add(header)
                       }
                   }
                   entitiesForThatString.add(model)

                   surgeonsModelList.add(model)
               }
               _surgeons.value = surgeonsModelList
               _status.value = Status.Loading(show = false)
           } catch (e: Throwable) {
               _status.value = Status.Loading(show = false)
               _status.value = Status.Error(message = e.message)
           }
        }
    }

    fun addOrEditSurgeon(mode: String, surgeonUniqueID: String?, firstName: String, lastName: String, hospital: String, specialization: String, contactPerson: String, workNo: String, mobileNo: String, mainNo: String, faxNo: String, multipleEmail: String, url: String, street: String, city: String, state: String, zip: String, notes: String) {
        viewModelScope.launch {
            try {
                _status.value = Status.Loading(show = true)
                repository.addOrEditSurgeon(mode, surgeonUniqueID, firstName, lastName, hospital, specialization, contactPerson, workNo, mobileNo, mainNo, faxNo, multipleEmail, url, street, city, state, zip, notes)
                _status.value = Status.Loading(show = false)
                _status.value = Status.Success("Successfully add surgeon")
            } catch (e: Throwable) {
                _status.value = Status.Loading(show = false)
                _status.value = Status.Error(message = e.message)
            }
        }
    }

    override fun onDestroy() {

    }

    override fun initComponentInjection() {
        DaggerSurgeonComponent.builder()
                .coreComponent(coreComponent)
                .surgeonModule(SurgeonModule())
                .build()
                .apply {
                    inject(viewModel = this@SurgeonViewModel)
                }
    }

    // unused codes
    fun viewSurgeon(surgeonUniqueID: String) {
        viewModelScope.launch {
            try {
                repository.viewSurgeon(surgeonUniqueID)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}