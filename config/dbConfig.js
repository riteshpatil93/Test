import { Sequelize } from "sequelize";

const sequelize = new Sequelize("sequelizedb", "root", "root",{
    host : "localhost",
    dialect : "mysql"
});

sequelize.authenticate().then(() => {
    console.log("Database Connected.....")
}).catch((err) => {
    console.log("Database Not Connected Please Connect The Database....")
    console.log(err);
});

export default sequelize;