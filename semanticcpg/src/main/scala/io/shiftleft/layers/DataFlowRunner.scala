package io.shiftleft.layers

import io.shiftleft.SerializedCpg
import io.shiftleft.codepropertygraph.Cpg
import io.shiftleft.passes.propagateedges.PropagateEdgePass
import io.shiftleft.passes.reachingdef.ReachingDefPass
import io.shiftleft.semanticsloader.Semantics

class DataFlowRunner(semantics: Semantics) {

  def run(cpg: Cpg, serializedCpg: SerializedCpg): Unit = {
    val enhancementExecList = List(new PropagateEdgePass(cpg, semantics), new ReachingDefPass(cpg))
    enhancementExecList.foreach(_.createApplySerializeAndStore(serializedCpg))
  }

}
