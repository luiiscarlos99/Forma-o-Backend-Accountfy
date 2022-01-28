package com.accountfy.livros.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountfy.livros.AnoMes;
import com.accountfy.livros.entities.Livro;
import com.accountfy.livros.repositories.LivroRepository;
import com.accountfy.livros.services.exceptions.RegistroNaoEncontradoException;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;

	public List<Livro> obterTodos() {
		return repository.findAll();
	}

	public List<Livro> obterComTituloContendo(String titulo) {
		List<Livro> obj = repository.findByTituloContaining(titulo);
		return obj;
	}

	public List<Livro> obterPublicadosEmV(List<AnoMes> ref) {
		List<Livro> obj = repository.findAll();
		List<Livro> lista = new ArrayList<Livro>();

		for (AnoMes am : ref) {
			for (Livro l : obj) {
				if (l.getAnoMesDePublicacao().getAno().equals(am.getAno())
						&& l.getAnoMesDePublicacao().getMes().equals(am.getMes())) {
					lista.add(l);
				}
			}
		}

		return lista;
	}

	public List<Livro> obterPublicadosEm(AnoMes ref) {
		List<Livro> obj = repository.findAll();
		List<Livro> lista = new ArrayList<Livro>();

		for (Livro l : obj) {
			if (l.getAnoMesDePublicacao().getAno().equals(ref.getAno())
					&& l.getAnoMesDePublicacao().getMes().equals(ref.getMes())) {
				lista.add(l);
			}
		}

		return lista;
	}

	public Livro encontrarPeloId(Long id) {
		Optional<Livro> obj = repository.findById(id);

		return obj.get();
	}

	public Long contarTodos() {
		return repository.count();
	}

	public Boolean naoEstaVazio() {
		Long count = repository.count();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean estaVazio() {
		Long count = repository.count();
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void salvar(Livro obj) {
		repository.save(obj);
	}

	public void excluirPeloId(Long id) {
		try {
			repository.deleteById(id);
		} catch (RuntimeException e) {
			throw new RegistroNaoEncontradoException(id);
		}
	}

	public void excluirTodos() {
		repository.deleteAll();
	}

	public void excluir(Livro obj) {
		repository.delete(obj);
	}
}
