package module.home

import javax.inject.{Inject, Singleton}

import com.typesafe.scalalogging.LazyLogging
import facade.{EventFacade, StockFacade}
import model.SKU
import module.common.ExtendAction
import play.api.mvc.Controller

@Singleton
class HomeController @Inject()() extends Controller
  with ExtendAction
  with LazyLogging {

  def www = AnalyticAction { implicit request =>
    Ok("")
  }

}
