
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object signup extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""
<form method="post" action=""""),_display_(Seq[Any](/*4.30*/routes/*4.36*/.Application.register())),format.raw/*4.59*/("""">
    <input type="text" device_model="First Name" /><br/>
    <input type="text" device_model="Last Name" /><br/>
    <input type="text" device_model="comments" /><br/>
    <h2>model-at-app</h2>
    <input type="submit" value="send" />
</form>
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 09 22:33:13 IST 2015
                    SOURCE: /home/sarath/xDlink/xDlink-server/app/views/signup.scala.html
                    HASH: 00e0d16924d69f92f6b20ddeaf9545865c9557c2
                    MATRIX: 775->1|886->18|923->21|954->44|993->46|1058->76|1072->82|1116->105
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4
                    -- GENERATED --
                */
            