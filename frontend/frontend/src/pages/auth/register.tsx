import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import mountain from "../../assets/icon.png"

export default function Register() {
    return (
        <div className="flex flex-col items-center justify-center h-screen bg-gray-100 dark:bg-gray-900">
            <div className="w-full max-w-md space-y-6 px-4">
                <div className="flex flex-col items-center">
                    <MountainIcon className="h-84 w-40 text-green-500" />
                    <div className="w-full text-left">
                        <h1 className="text-2xl font-bold">Cadastre-se</h1>
                    </div>
                </div>
                <div className="space-y-4">
                    <div>
                        <Label className="font-bold" htmlFor="name">
                            Nome
                        </Label>
                        <Input id="name" placeholder="Gabriel" type="text" />
                    </div>
                    <div>
                        <Label className="font-bold" htmlFor="lastName">
                            Sobrenome
                        </Label>
                        <Input id="lastName" placeholder="Pereira" type="text" />
                    </div>
                    <div>
                        <Label className="font-bold" htmlFor="email">
                            E-mail
                        </Label>
                        <Input id="email" placeholder="example@email.com" type="email" />
                    </div>
                    <div>
                        <Label className="font-bold" htmlFor="password">
                            Senha
                        </Label>
                        <Input id="password" type="password" />
                    </div>
                </div>
                <div className="space-y-2">
                    <Button className="w-full bg-green-500 text-white hover:bg-green-600">Register</Button>
                </div>
            </div>
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
