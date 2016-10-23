package module.home

import javax.inject.{Inject, Singleton}

import com.typesafe.scalalogging.LazyLogging
import module.common.ExtendAction
import play.api.mvc.Controller
import facade.ScenarioFacade

@Singleton
class HomeController @Inject()(scenarioFacade: ScenarioFacade) extends Controller
  with ExtendAction
  with LazyLogging {

  def www = Measurement { implicit request =>
    Ok(views.html.home(scenarioFacade.scenarios))
  }

}
