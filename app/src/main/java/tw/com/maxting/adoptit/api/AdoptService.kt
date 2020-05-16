package tw.com.maxting.adoptit.api

import retrofit2.http.GET
import retrofit2.http.Query
import tw.com.maxting.adoptit.data.Adopt

interface AdoptService {

    @GET("Service/OpenData/TransService.aspx?UnitId=QcbUEzN6E6DL")
    fun fetchAdopts(@Query("UnitId") unitId: String = "QcbUEzN6E6DL",
                    @Query("top") top: Int = 20,
                    @Query("skip") skip: Int = 0
    ): List<Adopt>

    companion object {
        const val BASE_URL = "https://data.coa.gov.tw/"
    }

}