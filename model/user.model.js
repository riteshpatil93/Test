import { DataTypes } from "sequelize";
import sequelize from "../config/dbConfig.js";

const user = sequelize.define("user", {
    user_id:{
        type : DataTypes.INTEGER,
        primaryKey : true,
        autoIncrement : true
    },
    name:{
        type : DataTypes.STRING,
        allowNull : false
    },
    email:{
        type : DataTypes.STRING,
        unique : true
    },
    password:{
        type : DataTypes.STRING,
        allowNull : false
    }
});

sequelize.sync()
.then(() => {
    console.log("User Table Created...")
}).catch((err) => {
    console.log(err);
})

export default user;