import Login from "./pages/auth/login";
import Home from "./pages/home";
import PontosColeta from "./pages/PontosDeColeta"
import './globals.css'
import Register from "./pages/auth/register";
import PassosColeta from "./pages/Instrução"
import ListaMateriais from "./pages/pesagem/MateriaisPermitidos";
import SelecionarMateriais from "./pages/pesagem/SelecionarMateriais";
import InserirResiduos from "./pages/pesagem/SelecionarItens";
import Pesagem from "./pages/pesagem/Pesagem";
import ConfirmacaoDesconto from "./pages/pesagem/Desconto";

export function App() {
  return (
    <ConfirmacaoDesconto />
  )
}
