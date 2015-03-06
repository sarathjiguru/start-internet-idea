// @SOURCE:/home/sarath/xDlink/xDlink-server/conf/routes
// @HASH:a75a53ed2eb749a12b836bafa6a3a34c2b07434a
// @DATE:Fri Mar 06 22:22:32 IST 2015


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
        

// @LINE:9
private[this] lazy val controllers_Application_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:12
private[this] lazy val controllers_Application_showLinkPage2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("send-a-link"))))
        

// @LINE:14
private[this] lazy val controllers_Application_receiveALink3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("send-a-link"))))
        

// @LINE:17
private[this] lazy val controllers_Registration_showRegister4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup-form"))))
        

// @LINE:18
private[this] lazy val controllers_Registration_registerDevice5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("signup"))))
        

// @LINE:21
private[this] lazy val controllers_Registration_googleRegId6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("googleid/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:25
private[this] lazy val controllers_RetrieveData_userAccountFor7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("useraccount/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:26
private[this] lazy val controllers_RetrieveData_googleIdFor8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("googleidforuser/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:29
private[this] lazy val controllers_Assets_at9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$all<.+>""","""controllers.Application.preFlight(all:String)"""),("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """send-a-link""","""controllers.Application.showLinkPage()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """send-a-link""","""controllers.Application.receiveALink()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup-form""","""controllers.Registration.showRegister()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """signup""","""controllers.Registration.registerDevice()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """googleid/$id<[^/]+>""","""controllers.Registration.googleRegId(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """useraccount/$id<[^/]+>""","""controllers.RetrieveData.userAccountFor(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """googleidforuser/$id<[^/]+>""","""controllers.RetrieveData.googleIdFor(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:9
case controllers_Application_index1(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:12
case controllers_Application_showLinkPage2(params) => {
   call { 
        invokeHandler(controllers.Application.showLinkPage(), HandlerDef(this, "controllers.Application", "showLinkPage", Nil,"GET", """show link""", Routes.prefix + """send-a-link"""))
   }
}
        

// @LINE:14
case controllers_Application_receiveALink3(params) => {
   call { 
        invokeHandler(controllers.Application.receiveALink(), HandlerDef(this, "controllers.Application", "receiveALink", Nil,"POST", """ receive a link""", Routes.prefix + """send-a-link"""))
   }
}
        

// @LINE:17
case controllers_Registration_showRegister4(params) => {
   call { 
        invokeHandler(controllers.Registration.showRegister(), HandlerDef(this, "controllers.Registration", "showRegister", Nil,"GET", """SignUp""", Routes.prefix + """signup-form"""))
   }
}
        

// @LINE:18
case controllers_Registration_registerDevice5(params) => {
   call { 
        invokeHandler(controllers.Registration.registerDevice(), HandlerDef(this, "controllers.Registration", "registerDevice", Nil,"POST", """""", Routes.prefix + """signup"""))
   }
}
        

// @LINE:21
case controllers_Registration_googleRegId6(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.Registration.googleRegId(id), HandlerDef(this, "controllers.Registration", "googleRegId", Seq(classOf[String]),"GET", """GoogleRegistrationid""", Routes.prefix + """googleid/$id<[^/]+>"""))
   }
}
        

// @LINE:25
case controllers_RetrieveData_userAccountFor7(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.RetrieveData.userAccountFor(id), HandlerDef(this, "controllers.RetrieveData", "userAccountFor", Seq(classOf[String]),"GET", """temporary access the in memory database populated""", Routes.prefix + """useraccount/$id<[^/]+>"""))
   }
}
        

// @LINE:26
case controllers_RetrieveData_googleIdFor8(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.RetrieveData.googleIdFor(id), HandlerDef(this, "controllers.RetrieveData", "googleIdFor", Seq(classOf[String]),"GET", """""", Routes.prefix + """googleidforuser/$id<[^/]+>"""))
   }
}
        

// @LINE:29
case controllers_Assets_at9(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     