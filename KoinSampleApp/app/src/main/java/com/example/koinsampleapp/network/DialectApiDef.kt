import com.example.koinsampleapp.model.Region
import retrofit2.http.GET

interface DialectApiDef {
    @GET("regions")
    suspend fun loadRegions(): List<Region>
}