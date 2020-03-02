package andrewliakh.examples.kotlin.jersey.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.litote.kmongo.id.jackson.IdJacksonModule
import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

@Provider
class KMongoProvider : ContextResolver<ObjectMapper> {
    override fun getContext(type: Class<*>): ObjectMapper {
        return KMongoJackson.mapper
    }
}

object KMongoJackson {
    val mapper = jacksonObjectMapper()

    init {
        mapper.registerModule(IdJacksonModule())
    }
}