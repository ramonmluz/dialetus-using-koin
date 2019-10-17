import com.example.koinsampleapp.model.Dialect
import com.example.koinsampleapp.model.Region
import retrofit2.http.GET
import retrofit2.http.Path

interface DialectApiDef {

    @GET("regions")
    suspend fun loadRegions(): List<Region>

    @GET("/regions/{region}/dialects")
    suspend fun loadDialects(@Path("region") region: String): List<Dialect>

}
