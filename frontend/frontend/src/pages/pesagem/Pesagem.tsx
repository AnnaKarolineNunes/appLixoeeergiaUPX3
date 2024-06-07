import { useState } from "react";
import { Button } from "@/components/ui/button";
import mountain from "../../assets/icon.png";
import weighingImage from "../../assets/weighing.png";

export default function Pesagem() {
    const [weight, setWeight] = useState(40); // Exemplo de peso total, você pode ajustar conforme necessário

    return (
        <div className="flex flex-col h-screen">
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
                <h1 className="text-center text-lg font-bold">Pesagem</h1>
                <div className="bg-[#F5F5F5] rounded-lg p-4 text-center w-full max-w-md mt-4">
                    <p>Coloque os itens em cima da balança e aguarde a liberação do desconto</p>
                </div>
                <img src={weighingImage} alt="Weighing" className="w-42 h-42 my-4" />
                <p className="text-center text-lg font-bold">Total em Kg</p>
                <div className="bg-[#F5F5F5] rounded-lg p-4 text-center w-full max-w-md mt-4">
                    <p className="text-2xl font-bold">{weight}</p>
                </div>
                <Button variant="default" className="bg-yellow-500 text-white w-full max-w-md mt-4">
                    Calcular desconto
                </Button>
            </div>
            <footer className="bg-[#F5F5F5] px-4 py-2 flex items-center justify-center w-full">
                <Button variant="ghost" className="flex items-center w-full">
                    <HomeIcon className="h-6 w-6 mr-2" />
                </Button>
            </footer>
        </div>
    );
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
    );
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
    );
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
    );
}
