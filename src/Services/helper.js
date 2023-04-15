import axios from "axios";

export const BASE_URL='http://localhost/9292';

export const myaxios= axios.create({
 
    baseURL:BASE_URL,

});