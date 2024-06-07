import { useState } from "react";
import { Button } from "@/components/ui/button";
import mountain from "../../assets/icon.png";

export default function InserirResiduos() {
    const [items, setItems] = useState(["Caixa de Leite", "Caixa de Papelão", "Vidro"]);
    const [newItem, setNewItem] = useState("");
    const [showPopup, setShowPopup] = useState(false);

    const handleAddItem = () => {
        if (newItem.trim()) {
            setItems([...items, newItem.trim()]);
            setNewItem("");
        }
    };

    const handleFinalize = () => {
        setShowPopup(true);
    };

    const handleClosePopup = () => {
        setShowPopup(false);
    };

    return (
        <div className="flex flex-col h-screen relative">
            <header className="bg-white text-black px-4 py-2 flex flex-col items-center justify-center">
                <MountainIcon />
                <div className="w-full flex justify-end mt-2">
                    <div className="flex items-center">
                        <UserIcon className="h-6 w-6 mr-2" />
                        <span>Anna</span>
                    </div>
                </div>
            </header>
            <div className="flex-1 flex flex-col items-center justify-center bg-white space-y-4 px-4">
                <h1 className="text-center text-lg font-bold">
                    Insira os resíduos que deseja reciclar
                </h1>
                <div className="w-full max-w-md space-y-4">
                    <div className="flex items-center">
                        <input
                            type="text"
                            placeholder="Adicionar Item..."
                            value={newItem}
                            onChange={(e) => setNewItem(e.target.value)}
                            className="border rounded p-2 flex-1"
                        />
                        <Button variant="ghost" onClick={handleAddItem} className="ml-2">
                            <AddIcon className="h-6 w-6" />
                        </Button>
                    </div>
                    <ul className="list-none space-y-2">
                        {items.map((item, index) => (
                            <li key={index} className="flex items-center space-x-2">
                                <input type="radio" name="recycle-item" id={`item-${index}`} className="h-5 w-5" />
                                <label htmlFor={`item-${index}`} className="text-lg">{item}</label>
                            </li>
                        ))}
                    </ul>
                </div>
                <Button variant="default" onClick={handleFinalize} className="bg-yellow-500 text-white w-full max-w-md mt-4">
                    Finalizar
                </Button>
            </div>
            <footer className="bg-[#F5F5F5] px-4 py-2 flex items-center justify-center w-full">
                <Button variant="ghost" className="flex items-center w-full">
                    <HomeIcon className="h-6 w-6 mr-2" />
                </Button>
            </footer>
            {showPopup && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <div className="bg-white rounded-lg p-4 w-full max-w-sm text-center">
                        <button onClick={handleClosePopup} className="absolute top-2 right-2">
                            <CloseIcon className="h-6 w-6" />
                        </button>
                        <h2 className="text-lg font-bold mb-4">Itens adicionados com sucesso!</h2>
                        <Button variant="default" className="bg-green-500 text-white w-full mb-2">
                            Liberar pesagem
                        </Button>
                        <Button onClick={handleClosePopup} variant="ghost" className="bg-gray-200 w-full">
                            Abrir a lista novamente
                        </Button>
                    </div>
                </div>
            )}
        </div>
    )
}

function MountainIcon(props: any) {
    return (
        <img
            {...props}
            src={mountain}
            alt="App Icon"
            width="120"
            height="64"
        />
    )
}

function UserIcon(props: any) {
    return (
        <svg
            {...props}
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        >
            <path d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2" />
            <circle cx="12" cy="7" r="4" />
        </svg>
    )
}

function HomeIcon(props: any) {
    return (
        <svg
            {...props}
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        >
            <path d="m3 9 9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z" />
            <polyline points="9 22 9 12 15 12 15 22" />
        </svg>
    )
}

function AddIcon(props: any) {
    return (
        <svg
            {...props}
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        >
            <line x1="12" y1="5" x2="12" y2="19" />
            <line x1="5" y1="12" x2="19" y2="12" />
        </svg>
    )
}

function CloseIcon(props: any) {
    return (
        <svg
            {...props}
            xmlns="http://www.w3.org/2000/svg"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            strokeWidth="2"
            strokeLinecap="round"
            strokeLinejoin="round"
        >
            <line x1="18" y1="6" x2="6" y2="18" />
            <line x1="6" y1="6" x2="18" y2="18" />
        </svg>
    )
}