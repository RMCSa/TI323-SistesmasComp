const mongoose = require('mongoose');

const url = 'mongodb://mongo:27017/docker-node-mongo';

const connectDb = async () => {
    try{
        mongoose.set('strictQuery', false)
        mongoose.connect(url)
        console.log("MongoDB conectado");
    }
    catch(error) {
        console.log(error)
        process.exit()
    }

    }


module.exports = connectDb;