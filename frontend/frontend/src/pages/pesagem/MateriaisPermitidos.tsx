import { Button } from "@/components/ui/button";
import mountain from "../../assets/icon.png";
import recycleIcon from "../../assets/recycle.png";
import { useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";
interface MaterialCategoryProps {
    category: string;
    allowed: string[];
    notAllowed: string[];
}

export default function ListaMateriais() {
    const navigate = useNavigate()
    const location = useLocation()
    const { collectionPoint, address } = location.state || { collectionPoint: "Ponto de coleta não selecionado" }

    const handleNavigateHome = () => {
        navigate('/')
    }

    const handleNavigateMateriais = () => {
        navigate('/selecionar-materiais', { state: { collectionPoint, address } })
    }

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
                <img src={recycleIcon} alt="Recycle" width="50" height="50" />
                <h1 className="text-center text-lg font-bold">
                    Veja abaixo a lista dos materiais permitidos nos pontos de coleta:
                </h1>
                <div className="w-full max-w-md space-y-6">
                    <MaterialCategory
                        category="Plástico"
                        allowed={["Tampas, potes, garrafas, recipientes de limpeza, brinquedos e baldes"]}
                        notAllowed={["Tomada, cabo de panela, espuma, acrílico e embalagens metalizadas"]}
                    />
                    <MaterialCategory
                        category="Vidro"
                        allowed={["Garrafas, potes, copos e frasco de remédio"]}
                        notAllowed={["Espelho, louça, cerâmica, óculos e porcelana"]}
                    />
                    <MaterialCategory
                        category="Papel"
                        allowed={["Jornais, revistas, caixas, rascunhos e escritos e papelão"]}
                        notAllowed={["Adesivos, etiquetas, fita crepe, papel carbono, fotografias, papéis engordurados, papel toalha e higiênico"]}
                    />
                </div>
                <Button variant="default" className="bg-yellow-500 text-white w-full max-w-md mt-4" onClick={handleNavigateMateriais}>
                    Avançar
                </Button>
            </div>
            <footer className="bg-[#F5F5F5] px-4 py-2 flex items-center justify-center w-full">
                <Button variant="ghost" className="flex items-center w-full" onClick={handleNavigateHome}>
                    <HomeIcon className="h-6 w-6 mr-2" />
                </Button>
            </footer>
        </div>
    )
}

function MaterialCategory({ category, allowed, notAllowed }: MaterialCategoryProps) {
    return (
        <div className="space-y-2">
            <h2 className="font-bold">{category}</h2>
            <div className="bg-[#F5F5F5] rounded-lg p-4">
                <div className="flex items-center mb-2">
                    <CheckIcon className="h-6 w-6 text-green-500 mr-2" />
                    <span>{allowed.join(", ")}</span>
                </div>
                <div className="flex items-center">
                    <XIcon className="h-6 w-6 text-red-500 mr-2" />
                    <span>{notAllowed.join(", ")}</span>
                </div>
            </div>
        </div>
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

function CheckIcon(props: any) {
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
            <path d="M20 6L9 17l-5-5" />
        </svg>
    )
}

function XIcon(props: any) {
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
