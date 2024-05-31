import { Label } from "@/components/ui/label"
import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import mountain from "../../assets/icon.png"

export default function Login() {
    return (
        <div className="flex flex-col items-center justify-center h-screen bg-gray-100 dark:bg-gray-900">
            <div className="w-full max-w-md space-y-6 px-4">
                <div className="flex flex-col items-center">
                    <MountainIcon className="h-84 w-40 text-green-500 p-4" />
                    <div className="w-full text-left">
                        <h1 className="text-2xl font-bold">Login</h1>
                    </div>
                </div>
                <div className="space-y-4">
                    <div>
                        <Label className="font-bold" htmlFor="email">
                            Email
                        </Label>
                        <Input id="email" placeholder="example@email.com" type="email" />
                    </div>
                    <div>
                        <div className="flex items-center justify-between">
                            <Label className="font-bold" htmlFor="password">
                                Password
                            </Label>
                        </div>
                        <Input id="password" type="password" />
                        <div className="flex items-center space-x-2 mt-2">
                            <a className="text-green-500 text-sm hover:underline" href="#">
                                Forgot password?
                            </a>
                            <a className="text-green-500 text-sm hover:underline" href="#">
                                Create an account
                            </a>
                        </div>
                    </div>
                </div>
                <div className="space-y-2">
                    <Button className="w-full bg-green-500 text-white hover:bg-green-600">Login</Button>
                    <Button className="w-full" variant="outline">
                        Continue as guest
                    </Button>
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


