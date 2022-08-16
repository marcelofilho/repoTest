package com.example.testerepo.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.testerepo.databinding.FragmentRepoBinding
import com.example.testerepo.presentation.adapter.RepoAdapter
import com.example.testerepo.presentation.viewmodel.RepoViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepoFragment : Fragment() {

    private val viewModel: RepoViewModel by viewModel()

    private val adapterRepo by lazy {
        RepoAdapter()
    }

    private lateinit var binding: FragmentRepoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding =  FragmentRepoBinding.inflate(inflater,container,false)
            setupRecyclerView()
            viewModel.apply {
                viewLifecycleOwner.lifecycleScope.launch{
                    viewModel.getRepo().onStart {  }.onCompletion {  }.collectLatest {
                        adapterRepo.submitData(it)
                    }.runCatching {
                        println()
                    }
                }
//                sucesso.observe(viewLifecycleOwner){
//                    it?.let {
//                        adapterRepo.submitData(it)
//                    }
//                }
            }

        return binding.root
    }

    private fun setupRecyclerView() = with(binding.repoRecyclerView){
        adapter = adapterRepo
    }

}