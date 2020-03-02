package andrewliakh.examples.kotlin.jersey.db

import com.mongodb.client.MongoCollection
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.*
import org.litote.kmongo.id.ObjectIdToStringGenerator.newStringId
import org.litote.kmongo.id.StringId

class Connect {
    companion object {
        val client = KMongo.createClient()
        val database = client.getDatabase("kotlin-example")
    }
}

data class Dog (
    @BsonId var _id: StringId<Dog> = newStringId(),
    var owner: String,
    var name: String,
    var bornAt: Int,
    var lastVaccineAt: Int?
) {
    companion object {
        fun collection(): MongoCollection<Dog> {
            return Connect.database.getCollection<Dog>("dogs")
        }
    }
}