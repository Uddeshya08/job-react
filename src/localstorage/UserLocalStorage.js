import { useState, useEffect } from "react";

export const setJwtLocal = (data, next) => {
    localStorage.setItem("jwt", data);
    next();
}

export const setUserId = (data, next) => {
    localStorage.setItem("userId", data);
    next();
}

export const getUserId = (key, next) => {
    localStorage.getItem(key);
}

export const getJwtLocal = (key, next) => {
    localStorage.getItem(key);
}