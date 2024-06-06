import { Button } from "@/components/ui/button";
import mountain from "../assets/icon.png";

export default function PassosColeta() {
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
                <h1 className="text-center text-lg font-bold">
                    Siga o passo a passo a seguir para depositar seus materiais recicláveis no ponto de coleta escolhido
                </h1>
                <div className="w-full max-w-md">
                    <div className="bg-[#F5F5F5] rounded-lg p-4 mb-4">
                        <h2 className="font-bold">Passo 1:</h2>
                        <Button variant="ghost" className="flex items-center justify-between w-full">
                            <span>Visualizar os materiais permitidos</span>
                            <MaterialIcon className="h-6 w-6" />
                        </Button>
                    </div>
                    <div className="bg-[#F5F5F5] rounded-lg p-4 mb-4">
                        <h2 className="font-bold">Passo 2:</h2>
                        <Button variant="ghost" className="flex items-center justify-between w-full">
                            <span>Selecionar os tipos de materiais</span>
                            <SelectionIcon className="h-6 w-6" />
                        </Button>
                    </div>
                    <div className="bg-[#F5F5F5] rounded-lg p-4 mb-4">
                        <h2 className="font-bold">Passo 3:</h2>
                        <Button variant="ghost" className="flex items-center justify-between w-full">
                            <span>Adicionar itens à lista</span>
                            <AddIcon className="h-6 w-6" />
                        </Button>
                    </div>
                    <div className="bg-[#F5F5F5] rounded-lg p-4 mb-4">
                        <h2 className="font-bold">Passo 4:</h2>
                        <Button variant="ghost" className="flex items-center justify-between w-full">
                            <span>Liberar pesagem</span>
                            <WeightIcon className="h-6 w-6" />
                        </Button>
                    </div>
                </div>
                <Button variant="default" className="bg-yellow-500 text-white w-full max-w-md mt-4">
                    Avançar
                </Button>
            </div>
            <footer className="bg-[#F5F5F5] px-4 py-2 flex items-center justify-center w-full">
                <Button variant="ghost" className="flex items-center w-full">
                    <HomeIcon className="h-6 w-6 mr-2" />
                </Button>
            </footer>
        </div>
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

function MaterialIcon(props: any) {
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
            <rect x="3" y="3" width="18" height="18" rx="2" ry="2" />
            <path d="M3 9h18M9 21V9" />
        </svg>
    )
}

function SelectionIcon(props: any) {
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
            <line x1="4" y1="20" x2="4" y2="10" />
            <line x1="10" y1="20" x2="10" y2="4" />
            <line x1="16" y1="20" x2="16" y2="14" />
            <line x1="22" y1="20" x2="22" y2="12" />
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

function WeightIcon(props: any) {
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
            <path d="M6 3h12M6 3a3 3 0 0 0 0 6h12a3 3 0 0 0 0-6M6 3h12m-9 6v13m6-13v13" />
        </svg>
    )
}
