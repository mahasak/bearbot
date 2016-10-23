package persist.jdbc

import persist.ScenarioPersist
import play.api.inject.Module
import play.api.{Configuration, Environment}

class PostgresModule extends Module {

  def bindings(environment: Environment, configuration: Configuration) = Seq(
    bind[ScenarioPersist].to[ScenarioJdbc]
  )

}
