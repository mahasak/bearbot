package facade

import javax.inject.{Inject, Singleton}

import entity.ScenarioEntity
import persist.ScenarioPersist

@Singleton
class ScenarioFacade @Inject()(persist: ScenarioPersist) {


  def scenarios: List[ScenarioEntity] = persist.findAll()


}
