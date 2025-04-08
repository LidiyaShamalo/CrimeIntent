package com.arkteya.criminal_intent

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.DialogFragment


class PhotoDialogFragment : DialogFragment() {

        private var imageUri: String? = null

        companion object {
            private const val ARG_IMAGE_URI = "image_uri"

            fun newInstance(imageUri: String): PhotoDialogFragment {
                val fragment = PhotoDialogFragment()
                val args = Bundle()
                args.putString(ARG_IMAGE_URI, imageUri)
                fragment.arguments = args
                return fragment
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            arguments?.let {
                imageUri = it.getString(ARG_IMAGE_URI)
            }
        }

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return activity?.let {
                val builder = AlertDialog.Builder(it)
                val inflater = requireActivity().layoutInflater
                val view = inflater.inflate(R.layout.fragment_photo_dialog, null)

                // Установите изображение в ImageView
                val imageView: ImageView = view.findViewById(R.id.iv_photo_scale)
                imageUri?.let { uriString ->
                    val uri = Uri.parse(uriString)
                    val bitmap = BitmapFactory.decodeStream(it.contentResolver.openInputStream(uri))
                    imageView.setImageBitmap(bitmap)
                }

                builder.setView(view)
                    .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }

                builder.create()
            } ?: throw IllegalStateException("Activity cannot be null")
        }
    }
