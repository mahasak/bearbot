package entity

import org.joda.time.DateTime

case class CustomerEntity(id: Long
                          , name: String
                          , enabled: Boolean
                          , created: Option[DateTime] = None
                          , updated: Option[DateTime] = None)
