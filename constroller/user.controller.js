import User from "../model/user.model.js"
import { request, response } from "express"

export const save = (request, response, next) => {
    User.create({
        name : request.body.name,
        email : request.body.email,
        password : request.body.password
    })
    .then((result) => {
        return response.status(200).json({Message : "Chhota Parteek Is Available"})
    })
}
export const userList = (request,response,next)=>{
    User.findAll({raw: true})
    .then(result=>{
     console.log(result);
    }).catch(err=>{
      console.log(err);
    })
 }
 
 export const getUserByEmail = (request,response,next)=>{
    User.findOne({where:{email: request.body.email}, raw: true})
    .then(result=>{
     console.log(result);
    }).catch(err=>{
     console.log(err);
    })
 }
 export const getUserById = (request, response, next) => {
    User.findByPk({where: { id: request.body.id}, raw: true})
    .then((result) => {
        return response.status(200).json({Data : result})
    })
    .catch((err) => {
        return response.status(500).json({Error : "Internal Server Error"})
    })
 }