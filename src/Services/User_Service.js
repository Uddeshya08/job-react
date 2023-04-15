import { myaxios } from "./helper";


export const signup=(user)=>{

    myaxios.post("/user/register").then((response)=> response.json());
};