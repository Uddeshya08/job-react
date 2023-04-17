import { myaxios } from "./helper";

// export const signup=(user)=>{
// return myaxios
//     .post("/user/register",user)
//     .then((response)=> response.json());
// };

export const signup = (user) => {
    return myaxios
      .post("/user/register", user, {
        headers: { "Content-Type": "application/json" },
        body: JSON.parse(user)
      })
      .then((response) => response.json());
  };
  