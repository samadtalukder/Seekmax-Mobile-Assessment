package com.samad_talukder.seekmaxhomeassignment.ui.home

/**
 * ViewModel class that handles business logic for fetching all job list data from the repository
 * @param application Application object used to create the ViewModel
 * @param allJobListUseCase Use case object for fetching all job list data
 */

/*@HiltViewModel
class PublishedJobViewModel @Inject constructor(
    private val mainRepository: PublishedJobsRepository,
) : ViewModel() {
    private var currentPage = 1
    private val liveData: MutableLiveData<ApiResult<Jobs>> =
        MutableLiveData()
    private val resultsList = mutableListOf<Jobs>()

    fun getJobsList() {
        viewModelScope.launch {
            liveData.value = ApiResult.Loading
            val response = mainRepository.getPublishedJob(currentPage)

            when {
                response.hasErrors() -> {
                    liveData.value = ApiResult.Error(response.errors?.get(0)?.message!!,1)
                }
                else -> {
                    val jobs = mapToJob(response)
                    resultsList.addAll(jobs)
                    liveData.value = ApiResult.Success(resultsList)

                }
            }
        }
    }

    private fun mapToJob(response: Response<JobsQuery.Data>): List<Jobs> {
        val jobs = response.data?.active()?.jobs()?.map {
            Jobs(
                it._id()!!,
                it.description()!!,
                it.haveIApplied()!!,
                it.industry()!!,
                it.location()!!,
                it.positionTitle()!!,
                SalaryRange(it.salaryRange()?.max()!!, it.salaryRange()?.min()!!)
            )
        } ?: emptyList()
        return jobs
    }

}*/

