package com.example.mysurgeon.procedure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.model.Procedure
import com.example.mysurgeon.model.Surgeon

class ProcedureViewModel(coreComponent: CoreComponent): BaseViewModel() {

    private val dummyList = mutableListOf<Procedure>()
    private val stringIndexHashMap = HashMap<String, MutableList<Procedure>>()
    private val procedureModelList = mutableListOf<Procedure>()
    private val _procedures = MutableLiveData<List<Procedure>>()
    val procedures: LiveData<List<Procedure>>
        get() = _procedures

    init {
        dummyList.add(Procedure("Carpal Tunnel", 1, 0, false))
        dummyList.add(Procedure("Carpal Tunnel Release", 2, 1, false))
        dummyList.add(Procedure("Drain thigh/Knee lesion", 2, 0, false))
        dummyList.add(Procedure("Neurectomy Hamstring", 1, 3, false))
        dummyList.add(Procedure("Remove Foreign Body", 6, 1, false))

    }

    fun addProcedureSpecificIndex() {
        dummyList.sortedBy { it.name }.forEach {
            val model = Procedure(it.name, it.linkedSurgeon, it.unlinkedSurgeon, it.isHeader)
            val firstLetterOfProcedureName = it.name.first().toString()

            var entitiesForThatString = stringIndexHashMap[firstLetterOfProcedureName]

            if (entitiesForThatString == null) {
                entitiesForThatString = ArrayList()
                stringIndexHashMap[firstLetterOfProcedureName] = entitiesForThatString
            }

            if (entitiesForThatString.isEmpty()) {
                val header = Procedure(firstLetterOfProcedureName, it.linkedSurgeon, it.linkedSurgeon, true)
                val filteredModelList = procedureModelList.filter { it.name == firstLetterOfProcedureName }
                if (filteredModelList.isEmpty()) {
                    procedureModelList.add(header)
                }
            }
            entitiesForThatString.add(model)
            procedureModelList.add(model)
        }
        _procedures.value = procedureModelList
    }

    override fun onDestroy() {

    }

    override fun initComponentInjection() {

    }
}