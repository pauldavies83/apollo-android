// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.antlr_tokens

import com.apollographql.apollo.api.Input
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.example.antlr_tokens.adapter.TestQuery_ResponseAdapter
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.Map
import kotlin.jvm.Transient

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
data class TestQuery(
  val operation: Input<String> = Input.absent()
) : Query<TestQuery.Data> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      if (this@TestQuery.operation.defined) {
        this["operation"] = this@TestQuery.operation.value
      }
    }

    override fun marshaller(): InputFieldMarshaller {
      return InputFieldMarshaller.invoke { writer ->
        if (this@TestQuery.operation.defined) {
          writer.writeString("operation", this@TestQuery.operation.value)
        }
      }
    }
  }

  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = variables

  override fun name(): OperationName = OPERATION_NAME

  override fun adapter(): ResponseAdapter<Data> = TestQuery_ResponseAdapter
  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val typeWithGraphQLKeywords: TypeWithGraphQLKeyword?
  ) : Operation.Data {
    data class TypeWithGraphQLKeyword(
      val on: String?,
      val null_: String?,
      val alias: String?
    )
  }

  companion object {
    const val OPERATION_ID: String =
        "197e186cfb461d1c38c0be4da7b182eff42e304043973b994c8c2de3535daea6"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}operation: String) {
          |  typeWithGraphQLKeywords {
          |    on
          |    null(fragment: ${'$'}operation)
          |    alias: null(fragment: "A string\nwith a new line")
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestQuery"
      }
    }
  }
}