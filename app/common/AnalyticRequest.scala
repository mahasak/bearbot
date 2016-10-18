package common

import play.api.mvc.{Request, WrappedRequest}

/**
  * Created by pasoktummarungsri on 2016-10-17.
  */
case class AnalyticRequest[A](request: Request[A]
                              , userid: Option[String]) extends WrappedRequest[A](request)
