enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, var idade: Int, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int, val nivel: Nivel, var descricao: String, val autor: String)

data class Formacao(val nome: String,  val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        for (u in usuario){
            inscritos.add(u)
            println("O usuario ${u.nome} foi matriculado em $nome com sucesso.")
            println()
        }
    }

    fun removerMatricula(vararg usuario: Usuario){
        for (u in usuario){
            inscritos.remove(u)
            println("O usuario ${u.nome} foi desmatriculado de $nome com sucesso.")
            println()
        }
    }

    fun adicinarConteudo(vararg conteudo: ConteudoEducacional){
        for (c in conteudo){
            conteudos.add(c)
            println("${c.nome} adicinado com sucesso de $nome.")
            println()
        }
    }

    fun removerConteudo(vararg conteudo: ConteudoEducacional){
        for (c in conteudo){
            conteudos.remove(c)
            println("${c.nome} removido com sucesso de $nome.")
            println()
        }
    }

    fun detalhesFormacao() {
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println()
            println("${conteudo.nome} --- Duracao de ${conteudo.duracao} minutos\n${conteudo.descricao}\n(Criado por ${conteudo.autor})")
        }
        println()
        println("Inscritos:")
        for (inscrito in inscritos) {
            println("Nome: ${inscrito.nome} --- Email: ${inscrito.email}")
        }
        println()
    }
}

fun main() {
    // Criando usuarios
    val u1 = Usuario("Joao", 25, "jao@gmail.com")
    val u2 = Usuario("Maria", 28, "maria@gmail.com")
    val u3 = Usuario("Carlos", 19, "carlos@gmail.com")

    // Criando conteudo educacional
    val c1 = ConteudoEducacional("ICC", 60, Nivel.BASICO, "Aulas de instroducao a ciencia da computacao", "Rafael Ivo")
    val c2 = ConteudoEducacional("CG", 180, Nivel.AVANCADO, "Aulas de computacao grafica", "Rafael Ivo")
    val c3 = ConteudoEducacional("POO", 120, Nivel.INTERMEDIARIO, "Aulas de programacao orientada a objeto", "Andre Sales")

    // Criando formações
    val formacaoCC = Formacao("Ciencia da computacao", Nivel.INTERMEDIARIO)
    val formacaoES = Formacao("Engenharia de softaware", Nivel.INTERMEDIARIO)

    // Teste 1
    formacaoCC.adicinarConteudo(c1, c2, c3)
    formacaoES.adicinarConteudo(c2, c3)
    formacaoCC.matricular(u1, u2, u3)
    formacaoCC.detalhesFormacao()

    // Teste 2
    formacaoCC.removerMatricula(u1, u3)
    formacaoCC.removerConteudo(c2, c3)
    formacaoCC.detalhesFormacao()
}
