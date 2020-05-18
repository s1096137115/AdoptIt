package tw.com.maxting.adoptit.singleton

import tw.com.maxting.adoptit.api.AdoptService

class Repository constructor(
        private val adoptService: AdoptService
) {
    suspend fun fetchAdopts(
            top: Int,
            skip: Int
    ) = adoptService.fetchAdopts(
            top = top,
            skip = skip
    )
}