package com.example.mysurgeon.journal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mysurgeon.core.BaseViewModel
import com.example.mysurgeon.core.di.CoreComponent
import com.example.mysurgeon.model.Journal
import com.example.mysurgeon.util.AppConstants
import timber.log.Timber
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class JournalViewModel(coreComponent: CoreComponent): BaseViewModel() {

    private val dummyJournalList = mutableListOf<Journal>()
    private val journalModelList = mutableListOf<Journal>()
    private val stringIndexHashMap = mutableMapOf<String, MutableList<Journal>>()

    private val _journal = MutableLiveData<List<Journal>>()
    val journal: LiveData<List<Journal>>
        get() = _journal

    init {
        dummyJournalList.add(Journal(
            "Lap Chloe Therapy",
            "Joe, John",
            "11:32 PM, Thu, Oct 22, 2015",
            "11:32 PM, Thu, Oct 23, 2015", AppConstants.ITEM_CONTENT))
        dummyJournalList.add(Journal(
            "Lap Chloe Therapy",
            "Doe, John",
            "11:32 PM, Thu, Oct 22, 2015",
            "11:32 PM, Thu, Oct 23, 2015", AppConstants.ITEM_CONTENT))
        dummyJournalList.add(Journal(
            "Lap Chloe Therapy",
            "Smith, John",
            "11:32 PM, Thu, Oct 22, 2015",
            "11:32 PM, Thu, Oct 23, 2015", AppConstants.ITEM_CONTENT))
        dummyJournalList.add(Journal(
            "Lap Chloe Therapy",
            "Smith, Joe",
            "11:32 PM, Thu, Oct 23, 2015",
            "11:32 PM, Thu, Oct 24, 2015", AppConstants.ITEM_CONTENT))
    }

    fun addJournalForSpecificIndex() {

        dummyJournalList.sortedBy { it.surgeon.first() }.forEach {
            val model = Journal(it.procedure, it.surgeon, it.startDate, it.endDate, it.type)
            val dates = it.startDate.split(",")
            val dateAsIndex = "${dates[2]},${dates[3]}"

            var entitiesForThatString = stringIndexHashMap[dateAsIndex]

            if (entitiesForThatString == null) {
                entitiesForThatString = ArrayList()
                stringIndexHashMap[dateAsIndex] = entitiesForThatString
            }

            if (entitiesForThatString.isEmpty()) {
                val header = Journal(
                    it.procedure,
                    it.surgeon,
                    it.startDate,
                    it.endDate,
                    AppConstants.ITEM_HEADER
                )
                val filteredModelList =
                    journalModelList.filter { it.startDate.contains(dateAsIndex) }

                if (filteredModelList.isEmpty()) {
                    journalModelList.add(header)
                }
            }
            entitiesForThatString.add(model)
            val footer = Journal(
                it.procedure,
                it.surgeon,
                it.startDate,
                it.endDate,
                AppConstants.ITEM_FOOTER
            )
            journalModelList.add(model)
            journalModelList.add(footer)
        }
        _journal.value = journalModelList
    }

    override fun onDestroy() {

    }

    override fun initComponentInjection() {

    }
}