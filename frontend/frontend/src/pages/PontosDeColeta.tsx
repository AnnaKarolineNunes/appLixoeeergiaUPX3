import { Button } from "@/components/ui/button";
import mountain from "../assets/icon.png";
import pontoColetas from "../assets/pontoColeta.png"

export default function PontosColeta() {
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
            <div className="flex-1 flex flex-col items-center justify-center bg-white space-y-4">
                <div className="bg-[#F5F5F5] rounded-lg w-[360px] h-[110px] flex items-center p-4 relative">
                    <img
                        src={pontoColetas}
                        width="150"
                        height="80"
                        alt="Collection Point"
                        className="rounded-[10px] border-[2px] mr-4"
                        style={{ position: 'absolute', top: '50%', left: '10px', transform: 'translateY(-50%)' }}
                    />
                    <div className="ml-[180px] space-y-1">
                        <h3 className="text-lg font-bold">Estação zona Norte</h3>
                        <p className="text-gray-500">Rua Bari, 123 - Bairro Guarani</p>
                    </div>
                </div>
                <div className="bg-[#F5F5F5] rounded-lg w-[360px] h-[110px] flex items-center p-4 relative">
                    <img
                        src={pontoColetas}
                        width="150"
                        height="80"
                        alt="Collection Point"
                        className="rounded-[10px] border-[2px] mr-4"
                        style={{ position: 'absolute', top: '50%', left: '10px', transform: 'translateY(-50%)' }}
                    />
                    <div className="ml-[180px] space-y-1">
                        <h3 className="text-lg font-bold">Estação zona sul</h3>
                        <p className="text-gray-500">Rua Aquiri, 123 - Bairro Guarani</p>
                    </div>
                </div>
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