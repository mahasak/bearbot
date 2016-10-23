package persist

import entity.ScenarioEntity
import org.joda.time.DateTime

trait ScenarioPersist {

  def find(id: Long): Option[ScenarioEntity]

  def findAll() : List[ScenarioEntity]

}
