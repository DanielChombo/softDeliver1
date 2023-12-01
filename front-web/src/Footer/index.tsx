import "./style.css";
import {ReactComponent as Linkedin} from "./Linkedin.svg"
import {ReactComponent as Youtube} from "./Youtube.svg"
import {ReactComponent as Instagram} from "./Instagram.svg"

function Footer(){
    return(
       <footer className="main-footer">
           App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
           <div className="footer-icons">
                <a href="#" target="_new">
                    <Youtube/>
                </a>
                <a href="#" target="_new">
                    <Linkedin/>
                </a>
                <a href="#" target="_new">
                    <Instagram/>
                </a>
           </div>
       </footer>
    )
}

export default Footer;