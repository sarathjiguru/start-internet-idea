// @SOURCE:/home/sarath/xDlink/xDlink-server/conf/routes
// @HASH:47dce3f99028f973405f4fef9992b79b9da33b45
// @DATE:Sat Mar 07 01:08:47 IST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers {

// @LINE:21
// @LINE:18
// @LINE:17
class ReverseRegistration {
    

// @LINE:18
def registerDevice(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                

// @LINE:21
def googleRegId(id:String, registration_id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "googleid" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("registration_id", registration_id)))))
}
                                                

// @LINE:17
def showRegister(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "signup-form")
}
                                                
    
}
                          

// @LINE:26
// @LINE:25
class ReverseRetrieveData {
    

// @LINE:26
def googleIdFor(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "googleidforuser/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:25
def userAccountFor(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "useraccount/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                
    
}
                          

// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def receiveALink(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "send-a-link")
}
                                                

// @LINE:9
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:6
def preFlight(all:String): Call = {
   Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("all", all))
}
                                                

// @LINE:12
def showLinkPage(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "send-a-link")
}
                                                
    
}
                          
}
                  


// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:21
// @LINE:18
// @LINE:17
class ReverseRegistration {
    

// @LINE:18
def registerDevice : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.registerDevice",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        

// @LINE:21
def googleRegId : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.googleRegId",
   """
      function(id,registration_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "googleid" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("registration_id", registration_id)])})
      }
   """
)
                        

// @LINE:17
def showRegister : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Registration.showRegister",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup-form"})
      }
   """
)
                        
    
}
              

// @LINE:26
// @LINE:25
class ReverseRetrieveData {
    

// @LINE:26
def googleIdFor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RetrieveData.googleIdFor",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "googleidforuser/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:25
def userAccountFor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RetrieveData.userAccountFor",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "useraccount/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        
    
}
              

// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def receiveALink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.receiveALink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "send-a-link"})
      }
   """
)
                        

// @LINE:9
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:6
def preFlight : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.preFlight",
   """
      function(all) {
      return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("all", all)})
      }
   """
)
                        

// @LINE:12
def showLinkPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.showLinkPage",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "send-a-link"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:29
// @LINE:26
// @LINE:25
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:21
// @LINE:18
// @LINE:17
class ReverseRegistration {
    

// @LINE:18
def registerDevice(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.registerDevice(), HandlerDef(this, "controllers.Registration", "registerDevice", Seq(), "POST", """""", _prefix + """signup""")
)
                      

// @LINE:21
def googleRegId(id:String, registration_id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.googleRegId(id, registration_id), HandlerDef(this, "controllers.Registration", "googleRegId", Seq(classOf[String], classOf[String]), "GET", """GoogleRegistrationid""", _prefix + """googleid""")
)
                      

// @LINE:17
def showRegister(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Registration.showRegister(), HandlerDef(this, "controllers.Registration", "showRegister", Seq(), "GET", """SignUp""", _prefix + """signup-form""")
)
                      
    
}
                          

// @LINE:26
// @LINE:25
class ReverseRetrieveData {
    

// @LINE:26
def googleIdFor(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RetrieveData.googleIdFor(id), HandlerDef(this, "controllers.RetrieveData", "googleIdFor", Seq(classOf[String]), "GET", """""", _prefix + """googleidforuser/$id<[^/]+>""")
)
                      

// @LINE:25
def userAccountFor(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RetrieveData.userAccountFor(id), HandlerDef(this, "controllers.RetrieveData", "userAccountFor", Seq(classOf[String]), "GET", """temporary access the in memory database populated""", _prefix + """useraccount/$id<[^/]+>""")
)
                      
    
}
                          

// @LINE:29
class ReverseAssets {
    

// @LINE:29
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:14
// @LINE:12
// @LINE:9
// @LINE:6
class ReverseApplication {
    

// @LINE:14
def receiveALink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.receiveALink(), HandlerDef(this, "controllers.Application", "receiveALink", Seq(), "POST", """ receive a link""", _prefix + """send-a-link""")
)
                      

// @LINE:9
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:6
def preFlight(all:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.preFlight(all), HandlerDef(this, "controllers.Application", "preFlight", Seq(classOf[String]), "OPTIONS", """OPTIONS""", _prefix + """$all<.+>""")
)
                      

// @LINE:12
def showLinkPage(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.showLinkPage(), HandlerDef(this, "controllers.Application", "showLinkPage", Seq(), "GET", """show link""", _prefix + """send-a-link""")
)
                      
    
}
                          
}
        
    