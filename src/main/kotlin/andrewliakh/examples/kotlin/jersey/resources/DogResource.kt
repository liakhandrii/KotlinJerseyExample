package andrewliakh.examples.kotlin.jersey.resources

import andrewliakh.examples.kotlin.jersey.db.*
import com.mongodb.client.MongoIterable
import org.litote.kmongo.id.StringId
import org.litote.kmongo.save
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("dogs")
@Produces(APPLICATION_JSON)
class DogResource {

    @GET
    fun listDogs(): MongoIterable<Dog> {
        return Dog.collection().find().map { it }
    }

    @GET
    @Path("{id}")
    fun getDog(@PathParam("id") id: String): Dog? {
        return Dog.collection().findById(id)
    }

    @POST
    fun createDog(token: Dog) {
        Dog.collection().save(token)
    }

    @PUT
    @Path("{id}")
    fun updateDog(@PathParam("id") id: String, dog: Dog) {
        dog._id = StringId(id)
        Dog.collection().replaceById(id, dog)
    }

    @DELETE
    @Path("{id}")
    fun deleteDog(@PathParam("id") id: String): Boolean {
        return Dog.collection().deleteById(id).deletedCount > 0
    }

}