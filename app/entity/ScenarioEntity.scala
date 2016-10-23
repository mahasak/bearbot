package entity

import org.joda.time.DateTime

case class ScenarioEntity(id: Long
                       , name: String
                       , story: String
                       , enabled: Boolean
                       , customerId: Long = 0
                       , created: DateTime
                       , updated: DateTime)
