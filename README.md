# Aplicativo Android para cadastro e Login utilizando o Firebase

Desenvolvido no Android Studio para aprendizado em mobile, este projeto foi implementado utilizando o Firebase para autenticação e gerenciamento de usuários. Priorizando a exploração de conceitos fundamentais, destaca-se a navegação fluida entre as telas de cadastro, login e Homepage, oferecendo uma experiência de usuário intuitiva. Além disso, o aplicativo oferece funcionalidades avançadas, como cadastro e login seguro de usuários e recursos de recuperação e redefinição de senha integrados ao Firebase Authentication.

# Dentre alguns códigos, podemos ver as lógicas de cadastro, login e recuperação de senha

```
private void cadastrarConta(String email, String senha){
        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                finish();
                startActivity(new Intent(this, Home.class));
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });

private void logarConta(String email, String senha){
        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                finish();
                startActivity(new Intent(this, Home.class));
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });

private void recuperarConta(String email){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                Toast.makeText(this, "Verifique seu e-mail para recuperar sua senha!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });

```

# Resultados finais
![recuperacaosenha](https://github.com/EricW900/cadastroeLogin/assets/113937150/1be686b1-3c2b-4b3f-bc36-620eafe03f57)
![telalogin](https://github.com/EricW900/cadastroeLogin/assets/113937150/ba2ea2ac-f026-4764-973c-295fa39a725d)
![telacadastro](https://github.com/EricW900/cadastroeLogin/assets/113937150/71311f93-e6d4-4ae4-a1e7-fea6ef7a223c)
![telaprincipal](https://github.com/EricW900/cadastroeLogin/assets/113937150/30c51523-d3b2-4868-80f0-56bfaf726253)
![home](https://github.com/EricW900/cadastroeLogin/assets/113937150/34486642-0b8b-45fd-9a6f-c3f4830cc0cd)
