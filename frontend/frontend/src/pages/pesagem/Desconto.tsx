import { Button } from "@/components/ui/button";
import mountain from "../../assets/icon.png";
import successImage from "../../assets/success.png"; // Certifique-se de que a imagem esteja no caminho correto
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default function ConfirmacaoDesconto() {
    const location = useLocation();
    const navigate = useNavigate();
    const { totalWeight, collectionPoint, address } = location.state || { totalWeight: 0, collectionPoint: "Ponto de coleta não selecionado", address: "Endereço não disponível" };
    const desconto = `${Math.floor(totalWeight / 100) * 10}Kw/h`; // Calcula 10 kWh para cada 100 gramas
    console.log(totalWeight, collectionPoint, address);
    const handleNavigateHome = () => {
        navigate("/");
    };

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
                <h1 className="text-center text-lg font-bold">Parabéns!</h1>
                <p className="text-center">Seu desconto foi de:</p>
                <div className="bg-[#F5F5F5] rounded-lg p-4 text-center w-full max-w-md">
                    <p className="text-2xl font-bold">{desconto}</p>
                </div>
                <img src={successImage} alt="Success" className="w-40 h-40 my-4" />
                <div className="bg-[#F5F5F5] rounded-lg p-4 text-center w-full max-w-md">
                    <p className="font-bold">Ponto de coleta escolhido:</p>
                    <p className="text-lg">{collectionPoint}</p>
                    <p>{address}</p>
                </div>
            </div>
            <footer className="bg-[#F5F5F5] px-4 py-2 flex items-center justify-center w-full">
                <Button variant="ghost" className="flex items-center w-full" onClick={handleNavigateHome}>
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
