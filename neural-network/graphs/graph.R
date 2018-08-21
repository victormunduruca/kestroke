dados = read.table("data-terr-v.txt",sep=" ",header=TRUE)
dados_validacao = read.table("validacao.txt",sep=" ",header=TRUE)
dados$erro
dados$iteracao
dados_validacao$validacao
dados_validacao$iteracao_validacao
attach(dados)
attach(dados_validacao)
plot(iteracao, erro, main="Erro atraves das Epocas, sem validacao", 
     xlab="Iterações", ylab="MSE", col="black", pch=19)
#lines(iteracao_validacao, validacao, col="green")

par(new=TRUE)
plot(iteracao_validacao, validacao,  xlab="Iterações", ylab="MSE", col="green")

