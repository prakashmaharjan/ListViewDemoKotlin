package com.example.prakashmaharjan.listviewdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.example.prakashmaharjan.listviewdemo.databinding.ActivityMainBinding
import com.example.prakashmaharjan.listviewdemo.databinding.RowMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setupListView()
        handleInsets()
    }

    private fun setupListView() {
        val adapter = AndroidVersionAdapter(viewModel.getAndroidVersions())
        binding.myListView.adapter = adapter
    }

    private fun handleInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(left = systemBars.left, right = systemBars.right)

            // Fix: Apply top inset to the toolbar to prevent overlap with status bar
            binding.toolbar.updatePadding(top = systemBars.top)
            
            // Handle bottom navigation bar for the list view
            binding.myListView.updatePadding(bottom = systemBars.bottom)
            
            insets
        }
    }

    private class AndroidVersionAdapter(private val versions: List<AndroidVersion>) : BaseAdapter() {
        override fun getCount(): Int = versions.size
        override fun getItem(position: Int): Any = versions[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binding: RowMainBinding
            val view: View

            if (convertView == null) {
                binding = RowMainBinding.inflate(android.view.LayoutInflater.from(parent?.context), parent, false)
                view = binding.root
                view.tag = binding
            } else {
                binding = convertView.tag as RowMainBinding
                view = convertView
            }

            val item = versions[position]
            binding.versionTextLabel.text = item.name
            binding.apiTextLabel.text = parent?.context?.getString(R.string.api_level, item.apiLevel)

            return view
        }
    }
}
