// @SOURCE:/home/sarath/xDlink/xDlink-server/conf/routes
// @HASH:cbb84558352aa1ae2a53b32491ca56e51dd41065
// @DATE:Mon Feb 09 22:33:11 IST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers {

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def receiveALink(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "send-a-link")
}
                                                

// @LINE:8
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:6
def preFlight(all:String): Call = {
   Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("all", all))
}
                                                

// @LINE:12
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "signup")
}
                                                
    
}
                          
}
                  


// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def receiveALink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.receiveALink",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "send-a-link"})
      }
   """
)
                        

// @LINE:8
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
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:14
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:14
class ReverseAssets {
    

// @LINE:14
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def receiveALink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.receiveALink(), HandlerDef(this, "controllers.Application", "receiveALink", Seq(), "POST", """ receive a link""", _prefix + """send-a-link""")
)
                      

// @LINE:8
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:6
def preFlight(all:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.preFlight(all), HandlerDef(this, "controllers.Application", "preFlight", Seq(classOf[String]), "OPTIONS", """OPTIONS""", _prefix + """$all<.+>""")
)
                      

// @LINE:12
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "POST", """SignUp""", _prefix + """signup""")
)
                      
    
}
                          
}
        
    