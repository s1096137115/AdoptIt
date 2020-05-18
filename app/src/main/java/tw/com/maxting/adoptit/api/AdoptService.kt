package tw.com.maxting.adoptit.api

import retrofit2.http.GET
import retrofit2.http.Query
import tw.com.maxting.adoptit.data.Adopt

interface AdoptService {

    @GET("Service/OpenData/TransService.aspx")
    suspend fun fetchAdopts(
            @Query("UnitId") unitId: String = "QcbUEzN6E6DL",
            @Query("\$top") top: Int = 20,
            @Query("\$skip") skip: Int = 0,
            @Query("album_file") albumFile: String = "http"
    ): List<Adopt>

    companion object {
        const val BASE_URL = "https://data.coa.gov.tw/"
    }

}