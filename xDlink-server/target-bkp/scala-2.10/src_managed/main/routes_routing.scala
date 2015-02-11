// @SOURCE:/home/sarath/xDlink/xDlink-server/conf/routes
// @HASH:cbb84558352aa1ae2a53b32491ca56e51dd41065
// @DATE:Mon Feb 09 22:33:11 IST 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_preFlight0 = Route("OPTIONS", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("all", """.+""",false))))
        

// @LINE:8
private[this] lazy val controllers_Application_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_Application_receiveALink2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("send-a-link"))))
        

// @LINE:12
private[this] lazy val controllers_Application_register3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:14
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$all<.+>""","""controllers.Application.preFlight(all:String)"""),("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """send-a-link""","""controllers.Application.receiveALink()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Application.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_preFlight0(params) => {
   call(params.fromPath[String]("all", None)) { (all) =>
        invokeHandler(controllers.Application.preFlight(all), HandlerDef(this, "controllers.Application", "preFlight", Seq(classOf[String]),"OPTIONS", """OPTIONS""", Routes.prefix + """$all<.+>"""))
   }
}
        

// @LINE:8
case controllers_Application_index1(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_Application_receiveALink2(params) => {
   call { 
        invokeHandler(controllers.Application.receiveALink(), HandlerDef(this, "controllers.Application", "receiveALink", Nil,"POST", """ receive a link""", Routes.prefix + """send-a-link"""))
   }
}
        

// @LINE:12
case controllers_Application_register3(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"POST", """SignUp""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:14
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     