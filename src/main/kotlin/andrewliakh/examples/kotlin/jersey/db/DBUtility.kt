package andrewliakh.examples.kotlin.jersey.db

import com.mongodb.client.MongoCollection
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.*
import org.litote.kmongo.util.KMongoUtil

fun <T> MongoCollection<T>.findById(id: String): T? {
    return this.findOne("{\"_id\": \"$id\"}")
}

fun <T> MongoCollection<T>.deleteById(id: String): DeleteResult {
    return this.deleteOne("{\"_id\": \"$id\"}")
}

fun <T> MongoCollection<T>.replaceById(id: String, newObject: T): UpdateResult {
    return this.replaceOne(KMongoUtil.toBson("{\"_id\": \"$id\"}"), newObject)
}