const express = require('express');

const router = express.Router();

const User = require('../models/user');

router.post('/post',async(req,res) => {
    try{
        const {username, password} = req.body;
        if (username === 'admin' && password === 'admin') {
            return res.status(200).json('Bem-vindo à página admin');
        }

        if (!(username && password)) {
            return res.status(200).json('Digite o nome e a senha');
        }

        const checkUser = await User.findOne({ username, password });

        if (checkUser) {
            return res.status(409).json({
                message: 'Usuário já existe'
            });
        }

        const user = new User({ username, password });
        await user.save();

        return res.status(201).json({
            message: 'Usuário criado com sucesso!',
            user
        })
    } catch (error) {
        console.log(error);
        return res.status(500).json({
            message: 'Erro interno'
        })
    };
})

module.exports = router;