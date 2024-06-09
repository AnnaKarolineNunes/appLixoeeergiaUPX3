import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from "./pages/auth/login";
import Home from "./pages/home";
import PontosColeta from "./pages/PontosDeColeta";
import Register from "./pages/auth/register";
import PassosColeta from "./pages/Instrução";
import ListaMateriais from "./pages/pesagem/MateriaisPermitidos";
import SelecionarMateriais from "./pages/pesagem/SelecionarMateriais";
import InserirResiduos from "./pages/pesagem/SelecionarItens";
import Pesagem from "./pages/pesagem/Pesagem";
import ConfirmacaoDesconto from "./pages/pesagem/Desconto";
import './globals.css';

export function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/pontos-de-coleta" element={<PontosColeta />} />
        <Route path="/instrucoes" element={<PassosColeta />} />
        <Route path="/materiais-permitidos" element={<ListaMateriais />} />
        <Route path="/selecionar-materiais" element={<SelecionarMateriais />} />
        <Route path="/selecionar-itens" element={<InserirResiduos />} />
        <Route path="/pesagem" element={<Pesagem />} />
        <Route path="/desconto" element={<ConfirmacaoDesconto />} />
      </Routes>
    </Router>
  );
}
